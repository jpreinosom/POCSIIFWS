/*
 * Copyright 2013 Red Hat Inc. and/or its affiliates and other contributors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,  
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package cl.util;

import org.switchyard.Exchange;
import org.switchyard.Message;
import org.switchyard.component.http.composer.HttpBindingData;
import org.switchyard.component.http.composer.HttpMessageComposer;
import org.switchyard.component.resteasy.composer.RESTEasyBindingData;
import org.switchyard.component.resteasy.composer.RESTEasyMessageComposer;

/**
 * Composes/decomposes multiple parameter RESTEasy messages.
 *
 * @author Magesh Kumar B <mageshbk@jboss.com> (C) 2013 Red Hat Inc.
 */
public class CustomHttpComposer extends HttpMessageComposer {

    /**
     * {@inheritDoc}
     */
    @Override
    public Message compose(HttpBindingData source, Exchange exchange) throws Exception {
        final Message message = super.compose(source, exchange);
        System.out.println("operation name " + exchange.OPERATION_NAME);
        System.out.println("ex message " + message.getContent());
        
        System.out.println("ex Provider " + message.getContext());
        
        System.out.println("ex Context " + source.getBodyAsString());
        
        
        System.out.println("ms Content " + message.getContent());
        
        
        
        System.out.println(message.getAttachment("msg"));
        System.out.println("paso 2 body"  + source.getBodyAsString());
        System.out.println("paso 1 header"  + source.getHeaders());
        return message;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public HttpBindingData decompose(Exchange exchange, HttpBindingData target) throws Exception {
       
        target = super.decompose(exchange, target);

        System.out.println("paso 2" + exchange.getConsumer());

        return target;
    }

}
