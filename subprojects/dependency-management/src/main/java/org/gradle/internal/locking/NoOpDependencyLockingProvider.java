/*
 * Copyright 2018 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.gradle.internal.locking;

import org.gradle.api.artifacts.DependencyConstraint;
import org.gradle.api.artifacts.result.ResolvedComponentResult;
import org.gradle.api.internal.artifacts.dsl.dependencies.DependencyLockingProvider;

import java.util.Collections;
import java.util.Set;

public class NoOpDependencyLockingProvider implements DependencyLockingProvider {

    private static final NoOpDependencyLockingProvider INSTANCE = new NoOpDependencyLockingProvider();

    public static DependencyLockingProvider getInstance() {
        return INSTANCE;
    }

    private NoOpDependencyLockingProvider() {
        // Prevent construction
    }

    @Override
    public Set<DependencyConstraint> findLockedDependencies(String configurationName) {
        return Collections.emptySet();
    }

    @Override
    public void persistResolvedDependencies(String configurationName, Set<ResolvedComponentResult> modules) {
        // No-op
    }
}