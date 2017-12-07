package ru.otus.classes;

import ru.otus.interfaces.Atm;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * {@code Caretaker} class.
 */
public class AtmCaretaker
{
    private Deque<AtmMemento> stack;

    public AtmCaretaker()
    {
        this.stack = new ArrayDeque<>();
    }

    public void save(Atm atm)
    {
        stack.addFirst(atm.save());
    }

    public void revert(Atm atm)
    {
        if (stack.peekFirst() != null) {
            atm.revert(stack.removeFirst());
        }
    }
}
