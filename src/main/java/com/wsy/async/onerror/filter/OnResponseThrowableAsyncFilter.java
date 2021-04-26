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

@Activate(group = {CommonConstants.PROVIDER, CommonConstants.CONSUMER}, order = 9998)
public class OnResponseThrowableAsyncFilter implements Filter, Filter.Listener {
    @Override
    public Result invoke(Invoker<?> invoker, Invocation invocation) throws RpcException {
        return invoker.invoke(invocation);
    }

    @Override
    public void onResponse(Result appResponse, Invoker<?> invoker, Invocation invocation) {
        System.out.println("OnResponse receive value : " + appResponse.getValue());
        if (invocation != null) {
            throw new RuntimeException("Exception from onResponse");
        }
    }

    @Override
    public void onError(Throwable t, Invoker<?> invoker, Invocation invocation) {
        System.out.println("OnResponseThrowableAsyncFilter onError execute : " + t.getMessage());
    }
}
