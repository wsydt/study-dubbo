package com.wsy.async.onerror.filter;

import org.apache.dubbo.common.constants.CommonConstants;
import org.apache.dubbo.common.extension.Activate;
import org.apache.dubbo.rpc.Filter;
import org.apache.dubbo.rpc.Invocation;
import org.apache.dubbo.rpc.Invoker;
import org.apache.dubbo.rpc.Result;
import org.apache.dubbo.rpc.RpcException;

/**
 * @author wangshuangyong 2021.4.26
 */

@Activate(group = {CommonConstants.PROVIDER, CommonConstants.CONSUMER}, order = 9990)
public class NormalSyncFilter implements Filter {

    @Override
    public Result invoke(Invoker<?> invoker, Invocation invocation) throws RpcException {
        System.out.println("normalSyncFilter before invoke ....");
        Result result = invoker.invoke(invocation);
        System.out.println("normal sync filter, the value may be null : " + result.getValue());
        return result;
    }
}
