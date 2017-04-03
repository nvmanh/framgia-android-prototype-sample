/*
 * Copyright (C) 2015 The Android Open Source Project
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

package manhnv.test.tasks;

import android.os.Bundle;
import android.support.annotation.VisibleForTesting;
import android.support.test.espresso.IdlingResource;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import manhnv.test.Injection;
import manhnv.test.R;
import manhnv.test.util.ActivityUtils;
import manhnv.test.util.EspressoIdlingResource;

public class TasksActivity extends AppCompatActivity {

    private TasksPresenter mTasksPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tasks_act);

        // Set up the toolbar.
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar ab = getSupportActionBar();
        ab.setHomeAsUpIndicator(R.drawable.ic_menu);
        ab.setDisplayHomeAsUpEnabled(true);

        TasksFragment tasksFragment =
                (TasksFragment) getSupportFragmentManager().findFragmentById(R.id.container);
        if (tasksFragment == null) {
            // Create the fragment
            tasksFragment = TasksFragment.newInstance();
            ActivityUtils.addFragmentToActivity(getSupportFragmentManager(), tasksFragment,
                    R.id.container);
        }

        // Create the presenter
        mTasksPresenter =
                new TasksPresenter(Injection.provideTasksRepository(getApplicationContext()),
                        tasksFragment, Injection.provideSchedulerProvider());

        TasksViewModel tasksViewModel =
                new TasksViewModel(getApplicationContext(), mTasksPresenter);

        tasksFragment.setViewModel(tasksViewModel);
    }

    @VisibleForTesting
    public IdlingResource getCountingIdlingResource() {
        return EspressoIdlingResource.getIdlingResource();
    }
}
