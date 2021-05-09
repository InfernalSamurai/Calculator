package ru.hei;

enum Type
{
    NUMBER( "", 0 ),
    OPEN_BRACKET( "(", 0 ),
    CLOSE_BRACKET( ")", 0 ),
    PLUS( "+", 1 ),
    MINUS( "-", 1 ),
    MULTIPLICATION( "*", 2 ),
    DIVISION( "/", 2 );

    private final String type;
    private final int precedence;

    Type( String type, int precedence )
    {
        this.type = type;
        this.precedence = precedence;
    }

    public static Type getType( String symbol )
    {
        for( Type value : Type.values() )
        {
            if( value.type.equals( symbol ) )
            {
                return value;
            }
        }

        return NUMBER;
    }

    public String getType()
    {
        return type;
    }

    public int getPrecedence()
    {
        return precedence;
    }

    public double operate( double first, double second )
    {
        switch( this )
        {
            case PLUS:
                return first + second;

            case MINUS:
                return first - second;

            case MULTIPLICATION:
                return first * second;

            case DIVISION:
                return first / second;

            default:
                return 0;
        }
    }
}
