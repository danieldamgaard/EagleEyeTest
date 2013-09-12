package dk.au.cs.eagleEye;

import algorithms.Manhattan;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

public class ManhattanTest {
  private Manhattan manhattan;
  
  public ManhattanTest() {
  }
  
  @Before
  public void setUp() {
    manhattan = new Manhattan();
  }

  @Test
  public void simple() {
    manhattan.Add(3.0);
    manhattan.Add(7.0);
    
    assertThat(10.0, equalTo(manhattan.Calculate()));
  }

  @Test
  public void negative() {
    manhattan.Add(-3.0);
    manhattan.Add(-7.0);
    
    assertThat(10.0, equalTo(manhattan.Calculate()));
  }
  
  @Test
  public void zeros() {
    manhattan.Add(0.0);
    manhattan.Add(-7.0);
    manhattan.Add(0.0);
    
    assertThat(7.0, equalTo(manhattan.Calculate()));
  }
}