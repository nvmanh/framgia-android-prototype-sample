package manhnv.test.util.helper;

import java.util.ArrayList;
import java.util.List;
import manhnv.test.data.Task;

/**
 * Created by root on 3/31/17.
 */

public class TaskTest {
    public static List<Task> createTaskListSamples() {
        List<Task> tasks = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            int id = i + 1;
            String taskName = String.format("task %d", id);
            String taskDescription = String.format("This is description of %s", taskName);
            tasks.add(new Task(taskName, taskDescription, String.valueOf(id)));
        }
        return tasks;
    }
}
