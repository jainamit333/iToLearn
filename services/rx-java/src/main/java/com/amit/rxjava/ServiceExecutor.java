package com.amit.rxjava;

import com.amit.impl.entity.Service;
import com.amit.impl.entity.ServiceBox;
import com.amit.impl.entity.ServiceRequest;
import com.amit.impl.repo.ServiceRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import rx.Observable;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

import java.util.List;
import java.util.Set;

/**
 * Created by amit on 13/7/16.
 */
@Component
public class ServiceExecutor {

    @Autowired
    private ServiceRequestRepository serviceRequestRepository;

    public void executeService(String lob,String requestType,String code){

            ServiceRequest serviceRequest = getDummyServiceRequest();
                    //serviceRequestRepository.findOneByLobAndRequestTypeAndCode(lob,requestType,code);
            Set<ServiceBox> serviceBoxSet = serviceRequest.getServiceManager().getServiceBox();
            // TODO: 13/7/16 sort serviceboxset according to evaluation order
            SmartObject  smartObject = new SmartObject();
            serviceBoxSet.stream().forEach(a->{
                executeServiceManager(smartObject,a);
            });
    }

    private void executeServiceManager(SmartObject smartObject, ServiceBox a) {
        smartObject.getSmartObjects().put(a.getServiceBoxName(),executeServiceBox(smartObject,a.getServices(),a.getServiceBoxName()));
    }

    private SmartObject executeServiceBox(SmartObject parentSmartObject,Set<Service> services,String serviceBoxName) {

        SmartObject smartObject = new SmartObject();
        List<SmartObject> serviceBoxParallelExecuetdResult = getSeviceResultAsync(parentSmartObject,services);
        smartObject.getSmartObjects().put(serviceBoxName,serviceBoxParallelExecuetdResult);
        return smartObject;
    }

    private List<SmartObject> getSeviceResultAsync(SmartObject smartObject,Set<Service> services) {
        Observable<SmartObject> serviceObservable = Observable.from(services).
                flatMap(service -> createServiceResult(smartObject,service.getServiceName())).
                subscribeOn(Schedulers.io());
        return serviceObservable.toList().toBlocking().single();
    }

    private Observable<SmartObject> createServiceResult(SmartObject smartObject,String serviceName) {

        SmartObject smartObjectServiceResult = new SmartObject();
        smartObjectServiceResult.getSmartObjects().put(serviceName,executeServiceFlow(smartObject,serviceName));
        return Observable.just(smartObjectServiceResult).subscribeOn(Schedulers.io());
    }

    private Object executeServiceFlow(SmartObject smartObject, String serviceName) {
        //todo ,preprocessing,requestAdapter,serviceInvoker,responseAdapter,postprocessing
        //todo call service , ? should assumme mapping is available from outside or not

        return null;
    }

    private ServiceRequest getDummyServiceRequest(){
        return null;
    }
}

