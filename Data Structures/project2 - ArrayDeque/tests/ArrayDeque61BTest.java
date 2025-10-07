import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static com.google.common.truth.Truth.assertThat;

public class ArrayDeque61BTest {
    @Test
    public void addFirstTest() {
        Deque61B<Integer> ad1 = new ArrayDeque61B<>();

        ad1.addFirst(1);
        ad1.addFirst(2);
        ad1.addFirst(3);
        ad1.addFirst(1);
        ad1.addFirst(2);
        ad1.addFirst(3);
        ad1.addFirst(1);
        ad1.addFirst(2);
        ad1.addFirst(3);

        assertThat(ad1.size()).isEqualTo(9);
    }

    @Test
    public void addLastTest() {
        Deque61B<Integer> ad1 = new ArrayDeque61B<>();

        ad1.addLast(1);
        ad1.addLast(2);
        ad1.addLast(3);
        ad1.addLast(1);
        ad1.addLast(2);
        ad1.addLast(3);
        ad1.addLast(1);
        ad1.addLast(2);
        ad1.addLast(3);

        assertThat(ad1.size()).isEqualTo(9);
    }

    @Test
    public void addFirstAfterRemoveToEmptyTest() {
        Deque61B<Integer> ad1 = new ArrayDeque61B<>();

        ad1.addFirst(1);
        ad1.addFirst(2);
        ad1.removeFirst();
        ad1.removeFirst();

        ad1.addFirst(1);

        assertThat(ad1.get(0)).isEqualTo(1);
    }

    @Test
    public void addLastAfterRemoveToEmptyTest() {
        Deque61B<Integer> ad1 = new ArrayDeque61B<>();

        ad1.addLast(1);
        ad1.addLast(2);
        ad1.removeFirst();
        ad1.removeFirst();

        ad1.addLast(1);

        assertThat(ad1.get(0)).isEqualTo(1);
    }

    @Test
    public void getTest() {
        Deque61B<Integer> ad1 = new ArrayDeque61B<>();

        assertThat(ad1.get(3)).isEqualTo(null);

        ad1.addLast(1);
        ad1.addLast(2);
        ad1.addLast(3);

        assertThat(ad1.get(0)).isEqualTo(1);
        assertThat(ad1.get(1)).isEqualTo(2);
        assertThat(ad1.get(2)).isEqualTo(3);
    }

    @Test
    public void isEmptyTest() {
        Deque61B<Integer> ad1 = new ArrayDeque61B<>();

        assertThat(ad1.isEmpty()).isTrue();

        ad1.addLast(1);

        assertThat(ad1.isEmpty()).isFalse();
    }

    @Test
    public void toListTest() {
        Deque61B<Integer> ad1 = new ArrayDeque61B<>();

        assertThat(ad1.toList()).isInstanceOf(ArrayList.class);

        ad1.addLast(1);
        ad1.addLast(2);
        ad1.addLast(3);

        List<Integer> ad1List = new ArrayList<>();

        ad1List = ad1.toList();

        assertThat(ad1List).containsExactly(1, 2, 3).inOrder();
    }

    @Test
    public void removeFirstTest() {
        Deque61B<Integer> ad1 = new ArrayDeque61B<>();

        assertThat(ad1.removeFirst()).isEqualTo(null);

        ad1.addFirst(1);
        ad1.addFirst(2);
        ad1.addFirst(3);

        Integer a = ad1.removeFirst();

        assertThat(a).isEqualTo(3);

        assertThat(ad1.size()).isEqualTo(2);
    }

    @Test
    public void removeLastTest() {
        Deque61B<Integer> ad1 = new ArrayDeque61B<>();

        assertThat(ad1.removeLast()).isEqualTo(null);

        ad1.addFirst(1);
        ad1.addFirst(2);
        ad1.addFirst(3);

        Integer a = ad1.removeLast();

        assertThat(a).isEqualTo(1);

        assertThat(ad1.size()).isEqualTo(2);
    }

    @Test
    public void removeFirstToEmpty() {
        Deque61B<Integer> ad1 = new ArrayDeque61B<>();

        assertThat(ad1.removeFirst()).isEqualTo(null);

        ad1.addFirst(1);
        ad1.addFirst(2);
        ad1.addFirst(3);

        ad1.removeFirst();
        ad1.removeFirst();

        assertThat(ad1.removeFirst()).isEqualTo(1);

        assertThat(ad1.size()).isEqualTo(0);
    }

    @Test
    public void removeLastToEmpty() {
        Deque61B<Integer> ad1 = new ArrayDeque61B<>();

        assertThat(ad1.removeLast()).isEqualTo(null);

        ad1.addFirst(1);
        ad1.addFirst(2);
        ad1.addFirst(3);

        ad1.removeLast();
        ad1.removeLast();

        assertThat(ad1.removeLast()).isEqualTo(3);

        assertThat(ad1.size()).isEqualTo(0);
    }

    @Test
    public void removeFirstToOne() {
        Deque61B<Integer> ad1 = new ArrayDeque61B<>();

        assertThat(ad1.removeFirst()).isEqualTo(null);

        ad1.addFirst(1);
        ad1.addFirst(2);
        ad1.addFirst(3);

        ad1.removeFirst();

        assertThat(ad1.removeFirst()).isEqualTo(2);

        assertThat(ad1.size()).isEqualTo(1);
    }

    @Test
    public void removeLastToOne() {
        Deque61B<Integer> ad1 = new ArrayDeque61B<>();

        assertThat(ad1.removeLast()).isEqualTo(null);

        ad1.addFirst(1);
        ad1.addFirst(2);
        ad1.addFirst(3);

        ad1.removeLast();

        assertThat(ad1.removeLast()).isEqualTo(2);

        assertThat(ad1.size()).isEqualTo(1);
    }

    @Test
    public void removeFirstTriggerResize() {
        Deque61B<Integer> ad1 = new ArrayDeque61B<>();

        for (int i = 0; i < 32; i++) ad1.addLast(i);

        assertThat(ad1.size()).isGreaterThan(8);

        for (int i = 0; i < 25; i++) ad1.removeFirst();

        assertThat(ad1.removeFirst()).isEqualTo(25);

        assertThat(ad1.size()).isEqualTo(6);
    }

    @Test
    public void removeLastTriggerResize() {
        Deque61B<Integer> ad1 = new ArrayDeque61B<>();

        for (int i = 0; i < 32; i++) ad1.addLast(i);

        assertThat(ad1.size()).isGreaterThan(8);

        for (int i = 0; i < 25; i++) ad1.removeLast();

        assertThat(ad1.removeLast()).isEqualTo(6);

        assertThat(ad1.size()).isEqualTo(6);
    }

    @Test
    public void getValidTest() {
        Deque61B<Integer> ad1 = new ArrayDeque61B<>();

        for (int i = 0; i < 32; i++) ad1.addLast(i);

        assertThat(ad1.get(3)).isEqualTo(3);
        assertThat(ad1.get(25)).isEqualTo(25);
    }

    @Test
    public void getOOBIndex() {
        Deque61B<Integer> ad1 = new ArrayDeque61B<>();

        for (int i = 0; i < 32; i++) ad1.addLast(i);

        assertThat(ad1.get(123123)).isEqualTo(null);
    }

    @Test
    public void getOOBNeg() {
        Deque61B<Integer> ad1 = new ArrayDeque61B<>();

        for (int i = 0; i < 32; i++) ad1.addLast(i);

        assertThat(ad1.get(-12)).isEqualTo(null);
    }

    @Test
    public void sizeTest() {
        Deque61B<Integer> ad1 = new ArrayDeque61B<>();

        for (int i = 0; i < 32; i++) ad1.addLast(i);

        assertThat(ad1.size()).isEqualTo(32);
    }

    @Test
    public void sizeAfterRemoveFromEmpty() {
        Deque61B<Integer> ad1 = new ArrayDeque61B<>();

        ad1.addLast(1);
        ad1.addLast(1);
        ad1.addLast(1);
        ad1.addLast(1);

        ad1.removeFirst();
        ad1.removeFirst();
        ad1.removeFirst();
        ad1.removeFirst();

        assertThat(ad1.size()).isEqualTo(0);
    }

    @Test
    public void sizeFromEmpty() {
        Deque61B<Integer> ad1 = new ArrayDeque61B<>();

        ad1.size();

        ad1.addFirst(1);

        assertThat(ad1.size()).isEqualTo(1);
    }

    @Test
    public void resizeUpAndDown() {
        Deque61B<Integer> ad1 = new ArrayDeque61B<>();

        for (int i = 0; i < 32; i++) ad1.addLast(i);

        for (int i = 0; i < 32; i++) ad1.removeFirst();

        assertThat(ad1.size()).isEqualTo(0);
    }
}
