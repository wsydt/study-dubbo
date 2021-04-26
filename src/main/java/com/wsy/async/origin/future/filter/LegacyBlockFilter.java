package com.wsy.async.origin.future.filter;

import org.apache.dubbo.common.constants.CommonConstants;
import org.apache.dubbo.common.extension.Activate;
import org.apache.dubbo.common.utils.StringUtils;
import org.apache.dubbo.rpc.Filter;
import org.apache.dubbo.rpc.Invocation;
import org.apache.dubbo.rpc.Invoker;
import org.apache.dubbo.rpc.Result;
import org.apache.dubbo.rpc.RpcContext;
import org.apache.dubbo.rpc.RpcException;
import org.apache.log4j.Logger;

/**
 * @author wangshuangyong 2021.4.26
 */

@Activate(group = {CommonConstants.PROVIDER, CommonConstants.CONSUMER})
public class LegacyBlockFilter implements Filter  {

    private Logger logger = Logger.getLogger(LegacyBlockFilter.class);

    @Override
    public Result invoke(Invoker<?> invoker, Invocation invocation) throws RpcException {
        RpcContext context = RpcContext.getContext();
        String filters = context.getAttachment("filters");
        if (StringUtils.isEmpty(filters)) {
            filters = "";
        }
        filters += "legacy-block-filter";
        context.setAttachment("filters", filters);
        Result result = invoker.invoke(invocation);
        logger.info("This is the default return value : " + result.getValue());
        if (result.hasException()) {
            System.out.println("LegacyBlockFilter : This will only happen when the real exception returns : " + result.getException());
            logger.error("This will only happen when the real exception returns : ", result.getException());
        }
        logger.info("LegacyBlockFilter : This message should not be blocked. ");
        return result;
    }

}
