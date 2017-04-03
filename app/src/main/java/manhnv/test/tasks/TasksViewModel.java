/*
 * Copyright 2016, The Android Open Source Project
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

import android.content.Context;
import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.graphics.drawable.Drawable;
import manhnv.test.BR;
import manhnv.test.R;

/**
 * Exposes the data to be used in the {@link TasksContract.View}.
 * <p>
 * {@link BaseObservable} implements a listener registration mechanism which is notified when a
 * property changes. This is done by assigning a {@link Bindable} annotation to the property's
 * getter method.
 */
public class TasksViewModel extends BaseObservable {

    private final TasksContract.Presenter mPresenter;
    int mTaskListSize = 0;
    private Context mContext;

    public TasksViewModel(Context context, TasksContract.Presenter presenter) {
        mContext = context;
        mPresenter = presenter;
    }

    @Bindable
    public boolean isNotEmpty() {
        return mTaskListSize > 0;
    }

    public void setTaskListSize(int taskListSize) {
        mTaskListSize = taskListSize;
        notifyPropertyChanged(BR.notEmpty);
    }
}
