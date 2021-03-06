/*
 *   Copyright (c) 2015, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 *
 *   WSO2 Inc. licenses this file to you under the Apache License,
 *   Version 2.0 (the "License"); you may not use this file except
 *   in compliance with the License.
 *   You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 *   Unless required by applicable law or agreed to in writing,
 *   software distributed under the License is distributed on an
 *   "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 *   KIND, either express or implied.  See the License for the
 *   specific language governing permissions and limitations
 *   under the License.
 */

package org.wso2.appserver.integration.common.artifacts.spring3.restful.simple.service.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Objects;

@Controller
@RequestMapping("/student")
public class StudentController {
    private static final Log log = LogFactory.getLog(StudentController.class);
    private static final long deployedTime = System.currentTimeMillis();

    @RequestMapping(method = RequestMethod.GET, value = "/deployedtime")
    @ResponseBody
    public String getDeployedtime() {
        return "{\"deployedTime\":\"" + Objects.toString(deployedTime, "") + "\"}";
    }

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public String getStatus() {
        String statusMsg = "{\"status\":\"success\"}";
        return statusMsg;
    }
}
