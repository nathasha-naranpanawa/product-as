/*
 * Copyright 2005-2007 WSO2, Inc. (http://wso2.com)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.wso2.appserver.sample.chad.command;

import org.wso2.appserver.sample.chad.ChadConstants;
import org.wso2.appserver.sample.chad.DuplicatePollException;
import org.wso2.appserver.sample.chad.data.ChadHibernateConfigFactory;
import org.wso2.appserver.sample.chad.data.ChadPersistenceManager;
import org.wso2.appserver.sample.chad.data.ChadPoll;

/**
 * Command to add a poll
 */
public class AddPollCommand implements ChadCommand{
    private ChadPoll poll;

    public AddPollCommand(ChadPoll poll) {
        this.poll = poll;
    }

    public void process() {
        try {
            new ChadPersistenceManager(ChadHibernateConfigFactory.
                            getDefaultConfig(ChadConstants.CHAD_HB_CONFIG)).addPoll(poll);
        } catch (DuplicatePollException e) {
            throw new RuntimeException(e);
        }
    }
}
