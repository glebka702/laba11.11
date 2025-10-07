import org.junit.Test;
import static org.junit.Assert.*;

public class ComplexTest {
    
    private static final double DELTA = 0.0001; // погрешность для double
    
    @Test
    public void testPower() {
        Complex z = new Complex(1, 1);
        
        // Проверка возведения в квадрат: (1+i)² = 0 + 2i
        Complex square = z.power(2);
        assertEquals(0, square.getReal(), DELTA);
        assertEquals(2, square.getImaginary(), DELTA);
        
        // Проверка возведения в куб: (1+i)³ = -2 + 2i
        Complex cube = z.power(3);
        assertEquals(-2, cube.getReal(), DELTA);
        assertEquals(2, cube.getImaginary(), DELTA);
    }
    
    @Test
    public void testSin() {
        // sin(0) = 0
        Complex zero = new Complex(0, 0);
        Complex sinZero = zero.sin();
        assertEquals(0, sinZero.getReal(), DELTA);
        assertEquals(0, sinZero.getImaginary(), DELTA);
        
        // sin(π/2) = 1
        Complex piHalf = new Complex(Math.PI/2, 0);
        Complex sinPiHalf = piHalf.sin();
        assertEquals(1, sinPiHalf.getReal(), DELTA);
        assertEquals(0, sinPiHalf.getImaginary(), DELTA);
    }
    
    @Test
    public void testCos() {
        // cos(0) = 1
        Complex zero = new Complex(0, 0);
        Complex cosZero = zero.cos();
        assertEquals(1, cosZero.getReal(), DELTA);
        assertEquals(0, cosZero.getImaginary(), DELTA);
    }
    
    @Test
    public void testExp() {
        // e^0 = 1
        Complex zero = new Complex(0, 0);
        Complex expZero = zero.exp();
        assertEquals(1, expZero.getReal(), DELTA);
        assertEquals(0, expZero.getImaginary(), DELTA);
        
        // e^(iπ) = -1 (формула Эйлера)
        Complex iPi = new Complex(0, Math.PI);
        Complex expIPi = iPi.exp();
        assertEquals(-1, expIPi.getReal(), DELTA);
        assertEquals(0, expIPi.getImaginary(), DELTA);
    }
    
    @Test
    public void testLog() {
        // ln(1) = 0
        Complex one = new Complex(1, 0);
        Complex lnOne = one.log();
        assertEquals(0, lnOne.getReal(), DELTA);
        assertEquals(0, lnOne.getImaginary(), DELTA);
        
        // ln(e) = 1
        Complex e = new Complex(Math.E, 0);
        Complex lnE = e.log();
        assertEquals(1, lnE.getReal(), DELTA);
        assertEquals(0, lnE.getImaginary(), DELTA);
    }
    
    @Test
    public void testNewFractalEquation() {
        // Тестируем новое уравнение фрактала
        Complex c = new Complex(0.3, 0.4);
        Complex z = new Complex(0, 0);
        
        // Проверяем одну итерацию нового уравнения
        Complex result = z.sin().add(c);
        
        // sin(0) = 0, поэтому результат должен быть равен c
        assertEquals(c.getReal(), result.getReal(), DELTA);
        assertEquals(c.getImaginary(), result.getImaginary(), DELTA);
    }
}
