package ru.hei;

class Dijkstra
{
    private final String string;
    private final Stack<String> stack;

    public Dijkstra( String string )
    {
        this.string = new PreparedString( string ).prepareAndGet();
        stack = new Stack<>();
    }

    public String sort()
    {
        StringBuilder result = new StringBuilder();

        for( String symbol : string.split( "" ) )
        {
            Type type = Type.getType( symbol );
            switch( type )
            {
                case NUMBER:
                    result.append( symbol );
                    break;

                case OPEN_BRACKET:
                    stack.put( symbol );
                    break;

                case CLOSE_BRACKET:
                    while( stack.notEmpty()
                           && !Type.OPEN_BRACKET.getType()
                                                .equals( stack.lastElement() ) )
                    {
                        result.append( " " )
                              .append( stack.pop() );
                    }

                    stack.pop();
                    break;

                case PLUS:
                case MINUS:
                case DIVISION:
                case MULTIPLICATION:
                    while( stack.notEmpty()
                           && type.getPrecedence() <= Type.getType( stack.lastElement() )
                                                          .getPrecedence() )
                    {
                        result.append( " " )
                              .append( stack.pop() );
                    }

                    stack.put( symbol );
                    result.append( " " );

                default:
                    break;
            }
        }

        while( stack.notEmpty() )
        {
            result.append( " " )
                  .append( stack.pop() );
        }

        return result.toString();
    }
}
