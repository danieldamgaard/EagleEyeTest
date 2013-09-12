package dk.au.cs.eagleEye;

import algorithms.Euclidean;
import algorithms.IgnoreAP;
import algorithms.Manhattan;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.pi4.locutil.GeoPosition;
import org.pi4.locutil.MACAddress;
import org.pi4.locutil.trace.SignalStrengthSamples;
import org.pi4.locutil.trace.TraceEntry;

public class IgnoreAPTest {
  private IgnoreAP ignoreAPe;
  private IgnoreAP ignoreAPm;
  private TraceEntry actual;
  
  public IgnoreAPTest() {
  }
  
  @Before
  public void setUp() {
    ignoreAPe = new IgnoreAP(new Euclidean());
    ignoreAPm = new IgnoreAP(new Manhattan());
    
    // Actual
    long timestamp = 11879160;
    GeoPosition pos = new GeoPosition(3.0, 4.0, 0.0, 0.0);
    
    short[] macParts = {12, 43, 54, 65, 23, 65};
    MACAddress mac = new MACAddress(macParts);
    
    SignalStrengthSamples sss = new SignalStrengthSamples();
    short[] mac2Parts = {12, 43, 54, 65, 23, 65};
    MACAddress mac2 = new MACAddress(mac2Parts);
    sss.put(mac2, -41.0);
    
    actual = new TraceEntry(timestamp, pos, mac, sss);
    
    ignoreAPe.setActual(actual);
    ignoreAPm.setActual(actual);
  }

  @Test
  public void eSimple() {
    // Actual
    long timestamp = 11879160;
    GeoPosition pos = new GeoPosition(3.0, 5.0, 0.0, 0.0);
    
    short[] macParts = {12, 43, 54, 65, 23, 65};
    MACAddress mac = new MACAddress(macParts);
    
    SignalStrengthSamples sss = new SignalStrengthSamples();
    short[] mac2Parts = {12, 43, 54, 65, 23, 65};
    MACAddress mac2 = new MACAddress(mac2Parts);
    sss.put(mac2, -41.0);
    
    assertThat(-41.0, equalTo(ignoreAPe.CompareTo(new TraceEntry(timestamp, pos, mac, sss))));
  }
}