import org.junit.Test

import org.junit.Assert.*

class MainKtTest {

    @Test
    fun komissionVISA() {
        val type =TYPE_VISA
        val transfer = 100
        val transfermonf = 0
        val result= komission(type,transfer,transfermonf)
        assertEquals(0.0,result,0.1)
    }
    @Test
    fun komissionVISAfalse() {
        val type =TYPE_VISA
        val transfer = 700_000
        val transfermonf = 0
        val result= komission(type,transfer,transfermonf)
        assertEquals(-1.0,result,0.1)    //непроходит по лимитам
    }
    @Test
    fun komissionVISAfalse1() {
        val type =TYPE_VISA
        val transfer = 700
        val transfermonf = 700_000
        val result= komission(type,transfer,transfermonf)
        assertEquals(3.0,result,0.1)    //непроходит по лимитам
    }
    @Test
    fun komissionVk() {
        val type =TYPE_Vk
        val transfer = 100
        val transfermonf = 0
        val result= komission(type,transfer,transfermonf)
        assertEquals(3.0,result,0.1)
    }
    @Test
    fun komissionVkfalse() {
        val type =TYPE_Vk
        val transfer = 100_000
        val transfermonf = 0
        val result= komission(type,transfer,transfermonf)
        assertEquals(-1.0,result,0.1)  //непроходит по лимитам
    }
    @Test
    fun komissionVkfalse1() {
        val type =TYPE_Vk
        val transfer = 100
        val transfermonf = 100_000
        val result= komission(type,transfer,transfermonf)
        assertEquals(-1.0,result,0.1)  //непроходит по лимитам
    }
    @Test
    fun komissionMaster() {
        val type =TYPE_mastercard
        val transfer = 100_000
        val transfermonf = 0
        val result= komission(type,transfer,transfermonf)
        assertEquals(620.0,result,0.1)
    }
    @Test
    fun komissionMasterfalse() {
        val type =TYPE_mastercard
        val transfer = 100_000_000
        val transfermonf = 0
        val result= komission(type,transfer,transfermonf)
        assertEquals(-1.0,result,0.1)  //непроходит по лимитам
    }
    @Test
    fun komissionMasterfalse1() {
        val type =TYPE_mastercard
        val transfer = 100
        val transfermonf = 800_000
        val result= komission(type,transfer,transfermonf)
        assertEquals(-1.0,result,0.1)  //непроходит по лимитам
    }
    @Test
    fun komissionFALSE() {
        val type ="maestro"
        val transfer = 100_000_000
        val transfermonf = 0
        val result= komission(type,transfer,transfermonf)
        assertEquals(-2.0,result,0.1)  //непроходит по  типу карты
    }

}
