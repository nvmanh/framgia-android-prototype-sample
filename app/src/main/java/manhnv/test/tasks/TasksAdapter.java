package manhnv.test.tasks;

import android.databinding.DataBindingUtil;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import manhnv.test.data.Task;
import manhnv.test.databinding.TaskItemBinding;
import java.util.List;

/**
 * Created by FRAMGIA\nguyen.viet.manh on 26/12/2016.
 */

public class TasksAdapter extends BaseAdapter {

    private List<Task> mTasks;

    private TasksContract.Presenter mUserActionsListener;

    public TasksAdapter(List<Task> tasks, TasksContract.Presenter itemListener) {
        setList(tasks);
        mUserActionsListener = itemListener;
    }

    public void replaceData(List<Task> tasks) {
        setList(tasks);
    }

    private void setList(List<Task> tasks) {
        mTasks = tasks;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return mTasks != null ? mTasks.size() : 0;
    }

    @Override
    public Task getItem(int i) {
        return mTasks.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        Task task = getItem(i);
        TaskItemBinding binding;
        if (view == null) {
            // Inflate
            LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());

            // Create the binding
            binding = TaskItemBinding.inflate(inflater, viewGroup, false);
        } else {
            binding = DataBindingUtil.getBinding(view);
        }

        // We might be recycling the binding for another task, so update it.
        // Create the action handler for the view
        binding.setTask(task);
        binding.executePendingBindings();
        return binding.getRoot();
    }
}