package serhii.hrynkevych.fourteen;

public class Fourteen {
    //14) How do you access hidden outer class variable in inner class?
    //14) Как получить доступ к скрытой переменной внешнего класса во внутреннем классе?

    //answer
    //To access non-static hidden outer class variable in inner class,
    // use this syntax : OuterClassName.this.variableName and to access
    // static hidden outer class variable in inner class use the same syntax
    // or use OuterClassName.variableName.

    //311 / 5000
    //Результаты перевода
    //Чтобы получить доступ к нестатической скрытой переменной внешнего класса
    // во внутреннем классе, используйте этот синтаксис: OuterClassName.this.variableName,
    // а для доступа к статической скрытой переменной внешнего класса во внутреннем классе
    // используйте тот же синтаксис или используйте OuterClassName.variableName.

    //OuterClassName.this.variableName - not static
    //OuterClassName.variableName - static
}
