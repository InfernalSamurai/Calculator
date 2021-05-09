package ru.hei;

class Stack<U>
{
    Object[] stack;
    int position;

    public Stack()
    {
        stack = new Object[2];
        position = 0;
    }

    public void put( U element )
    {
        if( position >= stack.length )
        {
            resize( stack.length * 2 );
        }

        stack[position++] = element;
    }

    private void resize( int size )
    {
        Object[] oldStack = new Object[stack.length];
        System.arraycopy( stack, 0, oldStack, 0, stack.length );

        stack = new Object[size];
        System.arraycopy( oldStack, 0, stack, 0, oldStack.length );
    }

    public U pop()
    {
        U result = (U)stack[--position];
        stack[position] = null;

        return result;
    }

    public boolean notEmpty()
    {
        return position > 0;
    }

    public U lastElement()
    {
        return (U)stack[position - 1];
    }

    public U firstElement()
    {
        return (U)stack[0];
    }
}
