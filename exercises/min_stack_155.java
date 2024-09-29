import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
public class min_stack_155 {
    
}

class MinStack {
    List<Integer> stack;
    List<Integer> mins;

    public MinStack() {
        this.stack = new ArrayList<>();
        this.mins = new ArrayList<>();
    }
    
    public void push(int val) {
        this.stack.add(val);
        var m = this.mins;
        if (m.isEmpty() ) {
            m.add(val);
        } else if (m.get(m.size() - 1) >= val) {
            m.add(val);
        }
    }
    public void pop() {
        var s = this.stack;
        var m = this.mins;
        if (Objects.equals(s.get(s.size() - 1), m.get(m.size() - 1))) {
            m.remove(m.size() - 1);
        }
        s.remove(s.size() - 1);
    }
    
    public int top() {
        return this.stack.get(this.stack.size() - 1);
    }
    
    public int getMin() {
        return this.mins.get(this.mins.size() - 1);
    }
}

