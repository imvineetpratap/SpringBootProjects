package com.imv.unit_testing.collectionsTest;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;

public class ListMockTest {
    List<String> mock=mock(ArrayList.class);
    @Test
    public void test(){
        when(mock.size()).thenReturn(5);
        Assertions.assertEquals(5,mock.size());
    }
    @Test
    public void returnDifferentValues(){
        when(mock.size()).thenReturn(5).thenReturn(10);
        Assertions.assertEquals(5,mock.size());
        Assertions.assertEquals(10,mock.size());
    }
    @Test
    public void returnParameters(){
        when(mock.get(0)).thenReturn("vineet");
        Assertions.assertEquals("vineet",mock.get(0));
    }
    @Test
    public void returnWithGenericParameters(){
        //any int is argument matcher
        when(mock.get(anyInt())).thenReturn("vineet");
        Assertions.assertEquals("vineet",mock.get(100));
    }
    @Test
public void verificationBasics(){
        //sut(system under test)
        String value=mock.get(0);
        String value1=mock.get(1);

        //verify
        verify(mock).get(0);
        verify(mock,times(2)).get(anyInt());
        verify(mock,atLeast(1)).get(anyInt());
        verify(mock,atLeastOnce()).get(anyInt());
        verify(mock,atMost(2)).get(anyInt());
        verify(mock,never()).get(2);
}

@Test
public void argumentCapturig(){
        //SUT
    mock.add("Something");

    //Verification
    ArgumentCaptor<String> captor=ArgumentCaptor.forClass(String.class);
    verify(mock).add(captor.capture());
    Assertions.assertEquals("Something",captor.getValue());
}
@Test
public void multipleArgumentCapturing(){
    //SUT
    mock.add("Something");
    mock.add("Something2");


    //Verification
    ArgumentCaptor<String> captor=ArgumentCaptor.forClass(String.class);
    verify(mock,times(2)).add(captor.capture());
    List<String> allvalues=captor.getAllValues();
    Assertions.assertEquals("Something",allvalues.get(0));
    Assertions.assertEquals("Something2",allvalues.get(1));
}


@Test
    public void mocking(){
        ArrayList list=mock(ArrayList.class);
        list.get(0);//null
    list.size();//0
    list.add("test");
    list.add("test2");
    list.size();//0
    when(list.size()).thenReturn(5);
    Assertions.assertEquals(5,list.size());
}
//with spy original behaviour of list is retained
    @Test
    public void spying(){
        ArrayList list=spy(ArrayList.class);
        list.add("hi");
        list.get(0);//hi
        list.size();//1
        list.add("test");
        list.add("test2");
        list.size();//3
        when(list.size()).thenReturn(5);//u took control from here and previous state is lost
        Assertions.assertEquals(5,list.size());//size=5 true
    }
}
