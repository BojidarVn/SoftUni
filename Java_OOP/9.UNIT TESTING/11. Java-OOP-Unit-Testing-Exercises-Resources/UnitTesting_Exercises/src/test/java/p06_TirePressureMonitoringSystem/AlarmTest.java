package p06_TirePressureMonitoringSystem;


import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class AlarmTest {



    @Test
    public void testGetAlarmOnWithLowerValue() {
        Sensor sensor=mock(Sensor.class);
        when(sensor.popNextPressurePsiValue()).thenReturn(16.9);
        Alarm alarm=new Alarm(sensor);
        alarm.check();
        assertTrue(alarm.getAlarmOn());
    }

    @Test
    public void testGetAlarmOnWithHigherValue() {
        Sensor sensor=mock(Sensor.class);
        when(sensor.popNextPressurePsiValue()).thenReturn(21.1);
        Alarm alarm=new Alarm(sensor);
        alarm.check();
        assertTrue(alarm.getAlarmOn());
    }

    @Test
    public void testGetAlarmWithNormalValue(){
        Sensor sensor=mock(Sensor.class);
        when(sensor.popNextPressurePsiValue()).thenReturn(18D);
        Alarm alarm=new Alarm(sensor);
        alarm.check();
        assertFalse(alarm.getAlarmOn());
    }
}
