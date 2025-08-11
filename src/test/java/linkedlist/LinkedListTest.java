package linkedlist;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class LinkedListTest {

    @Test
    @DisplayName("Constructor initializes length=1 and first value")
    void constructorInitializes() {
        LinkedList ll = new LinkedList(10);
        assertThat(ll.getLength()).isEqualTo(1);
        assertThat(ll.get(0).value).isEqualTo(10);
        assertThat(ll.get(1)).isNull();
    }

    @Test
    @DisplayName("append adds to tail and updates length")
    void appendWorks() {
        LinkedList ll = new LinkedList(1);
        ll.append(2);
        ll.append(3);

        assertThat(ll.getLength()).isEqualTo(3);
        assertThat(values(ll)).containsExactly(1, 2, 3);
        assertThat(ll.get(ll.getLength() - 1).value).isEqualTo(3);
    }

    @Test
    @DisplayName("prepend adds to head and updates length")
    void prependWorks() {
        LinkedList ll = new LinkedList(2);
        ll.prepend(1);
        ll.prepend(0);

        assertThat(ll.getLength()).isEqualTo(3);
        assertThat(values(ll)).containsExactly(0, 1, 2);
        assertThat(ll.get(0).value).isEqualTo(0);
    }

    @Test
    @DisplayName("get within bounds and set by index")
    void getAndSet() {
        LinkedList ll = new LinkedList(0);
        ll.append(1);
        ll.append(2);

        assertThat(ll.get(1).value).isEqualTo(1);
        assertThat(ll.set(1, 42)).isTrue();
        assertThat(ll.get(1).value).isEqualTo(42);

        assertThat(ll.get(-1)).isNull();
        assertThat(ll.get(3)).isNull();
        assertThat(ll.set(-1, 5)).isFalse();
        assertThat(ll.set(3, 5)).isFalse();
    }

    @Test
    @DisplayName("insert at head, middle, tail")
    void insertVariants() {
        LinkedList ll = new LinkedList(1);
        // head
        assertThat(ll.insert(0, 0)).isTrue();
        // tail (index == length)
        assertThat(ll.insert(ll.getLength(), 3)).isTrue();
        // middle
        assertThat(ll.insert(2, 2)).isTrue();

        assertThat(values(ll)).containsExactly(0, 1, 2, 3);
        assertThat(ll.getLength()).isEqualTo(4);
    }

    @Test
    @DisplayName("remove first, middle, last")
    void removeVariants() {
        LinkedList ll = new LinkedList(0);
        ll.append(1);
        ll.append(2);
        ll.append(3); // [0,1,2,3]

        // first
        var first = ll.removeFirst();
        assertThat(first.value).isEqualTo(0);
        assertThat(values(ll)).containsExactly(1, 2, 3);

        // middle (index 1 -> value 2)
        var mid = ll.remove(1);
        assertThat(mid.value).isEqualTo(2);
        assertThat(values(ll)).containsExactly(1, 3);

        // last
        var last = ll.removeLast();
        assertThat(last.value).isEqualTo(3);
        assertThat(values(ll)).containsExactly(1);
        assertThat(ll.getLength()).isEqualTo(1);
    }

    @Test
    @DisplayName("remove invalid indices returns null (requires bounds fix)")
    void removeInvalidIndices() {
        LinkedList ll = new LinkedList(10);
        ll.append(20); // length = 2, valid indices: 0..1
        assertThat(ll.remove(-1)).isNull();
        assertThat(ll.remove(2)).isNull(); // should be null
    }

    @Test
    @DisplayName("reverse: single and multiple")
    void reverseCases() {
        // single
        LinkedList one = new LinkedList(1);
        one.reverse();
        assertThat(values(one)).containsExactly(1);

        // multiple
        LinkedList ll = new LinkedList(1);
        ll.append(2);
        ll.append(3);
        ll.append(4); // [1,2,3,4]
        ll.reverse(); // [4,3,2,1]

        assertThat(values(ll)).containsExactly(4, 3, 2, 1);
    }

    // --- helper ---
    private static int[] values(LinkedList ll) {
        int n = ll.getLength();
        int[] out = new int[n];
        for (int i = 0; i < n; i++) out[i] = ll.get(i).value;
        return out;
    }
}
