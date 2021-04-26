package com.wsy.async.origin.future.filter;

import org.apache.dubbo.common.constants.CommonConstants;
import org.apache.dubbo.common.extension.Activate;
import org.apache.dubbo.common.utils.StringUtils;
import org.apache.dubbo.rpc.Filter;
import org.apache.dubbo.rpc.Invocation;
import org.apache.dubbo.rpc.Invoker;
import org.apache.dubbo.rpc.ListenableFilter;
import org.apache.dubbo.rpc.Result;
import org.apache.dubbo.rpc.RpcContext;
import org.apache.dubbo.rpc.RpcException;
import org.apache.log4j.Logger;

/**
 * @author wangshuangyong 2021.4.26
 */

@Activate(group={CommonConstants.PROVIDER, CommonConstants.CONSUMER})
public class LegacyListenableFilter extends ListenableFilter {

    private Logger logger = Logger.getLogger(LegacyListenableFilter.class);

    public LegacyListenableFilter() {
        super.listener = new CallbackListener();
    }

    @Override
    public Result invoke(Invoker<?> invoker, Invocation invocation) throws RpcException {
        RpcContext context = RpcContext.getContext();
        String filters = context.getAttachment("filters");
        if (StringUtils.isEmpty(filters)) {
            filters = "";
        }
        filters += "legacy-listenable-filter";
        context.setAttachment("filters", filters);
        return invoker.invoke(invocation);
    }

    private class CallbackListener implements Filter.Listener {

        @Override
        public void onResponse(Result appResponse, Invoker<?> invoker, Invocation invocation) {
            System.out.println("callback received in LegacyListenableFilter.onResponse : " + appResponse.getValue());
        }

        @Override
        public void onError(Throwable t, Invoker<?> invoker, Invocation invocation) {

        }
    }
}
