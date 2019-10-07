/**
 *  Copyright 2005-2016 Red Hat, Inc.
 *
 *  Red Hat licenses this file to you under the Apache License, version
 *  2.0 (the "License"); you may not use this file except in compliance
 *  with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or
 *  implied.  See the License for the specific language governing
 *  permissions and limitations under the License.
 */
package io.fabric8.groups.internal;

import io.fabric8.groups.GroupListener;

/**
 * "Event" operation performed on {@link ZooKeeperGroup} is meant to call registered listeners.
 */
class EventOperation implements Operation {

    private final ZooKeeperGroup cache;
    private final GroupListener.GroupEvent event;

    EventOperation(ZooKeeperGroup cache, GroupListener.GroupEvent event) {
        this.cache = cache;
        this.event = event;
    }

    @Override
    public void invoke() {
        cache.callListeners(event);
    }

    @Override
    public String toString() {
        return "EventOperation{ " + cache.getId() + ", " + event + " }";
    }

}
