import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class TodoList {
    private List<Todo> todoList = new ArrayList<>();

    public void addTodo(Todo t) {
        todoList.add(t);
    }

    public List<Todo> getTodos() {
        return todoList;
    }

    public int getNumberOfItemsLeft() {
        int sum = 0;
        for (Todo item : todoList) {
            if (item.getState() == State.NON_COMPLETED) {
                sum++;
            }
        }
        return sum;
    }

    public List<String> getMostImportantTodosText() {
        int min = 6;
        List<String> result = new ArrayList<>();
        for (Todo item : todoList) {
            if (item.getPriority() < min) {
                min = item.getPriority();
            }
        }
        for (Todo item : todoList) {
            if (item.getPriority() == min) {
                result.add(item.getText());
            }
        }
        return result;
    }

    public void deleteCompleted() {
        List<Todo> result = new ArrayList<>();
        for (Todo item : todoList) {
            if (item.getState() == State.COMPLETED) {
                result.add(item);
            }
        }
        todoList.removeAll(result);
    }
}
