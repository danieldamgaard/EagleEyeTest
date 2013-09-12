/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.au.cs.eagleEye;

import algorithms.Euclidean;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

/**
 *
 * @author Daniel
 */
public class EuclideanTest {
  private Euclidean euclidean;
  
  @Before
  public void setUp() {
    euclidean = new Euclidean();
  }
  
  @Test
  public void simpleTest() {
    euclidean.Add(4.0);
    euclidean.Add(3.0);
    
    assertThat(5.0, equalTo(euclidean.Calculate()));
  }
  
  @Test
  public void negativeSimpleTest() {
    euclidean.Add(-4.0);
    euclidean.Add(3.0);
    
    assertThat(5.0, equalTo(euclidean.Calculate()));
  }
  
  @Test
  public void singleValueTest() {
    euclidean.Add(4.0);
    
    assertThat(4.0, equalTo(euclidean.Calculate()));
  }
  
  @Test
  public void singleNegativeValueTest() {
    euclidean.Add(-4.0);
    
    assertThat(4.0, equalTo(euclidean.Calculate()));
  }
  
  @Test
  public void singleValueWith0sTest() {
    euclidean.Add(0.0);
    euclidean.Add(2.0);
    euclidean.Add(0.0);
    
    assertThat(2.0, equalTo(euclidean.Calculate()));
  }
}