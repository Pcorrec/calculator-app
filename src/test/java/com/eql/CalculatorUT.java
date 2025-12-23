package com.eql;

import com.eql.services.Calculator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class CalculatorUT {

  private Calculator calculator =  new Calculator();

  @Test
  public void testSum(){
    Assertions.assertEquals(7,  calculator.sum(4,3));
  }
}
