package serhii.hrynkevych.fortyfour;

public class FortyFour {
    //44) How do you access hidden outer class variable in inner class?
    //44) Как получить доступ к скрытой переменной внешнего класса во внутреннем классе?

    //answer

    //OuterClassName.this.variableName - not static
    //OuterClassName.variableName - static

    //To access non-static hidden outer class variable in inner class,
    // use this syntax : OuterClassName.this.variableName and to access static hidden outer class
    // variable in inner class use the same syntax or access like OuterClassName.variableName.

    //Чтобы получить доступ к нестатической скрытой переменной внешнего класса во внутреннем классе,
    // используйте этот синтаксис: OuterClassName.this.variableName, а для доступа
    // к статической скрытой переменной внешнего класса во внутреннем классе используйте
    // тот же синтаксис или доступ, как OuterClassName.variableName.
}
