package com.example.myloginmvvm

import com.example.myloginmvvm.data.Data
import com.example.myloginmvvm.data.Support
import com.example.myloginmvvm.data.UserListResponse
import com.example.myloginmvvm.data.UserRes
import com.example.myloginmvvm.data.UserResponse
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class ModelTest {

    @Test
    fun `Data model test`(){

        val dataObj = Data(
            1,
            "Satish",
            2023,
            "test",
            "test"
        )
        Assert.assertEquals(1,dataObj.id)
        Assert.assertEquals("Satish",dataObj.name)
        Assert.assertEquals(2023,dataObj.year)
        Assert.assertEquals("test",dataObj.color)
        Assert.assertEquals("test",dataObj.pantone_value)

    }

    @Test
    fun `Support model test`(){

        val data = Support(
            "text",
            "www.google.com"
        )
        Assert.assertEquals("text",data.text)
        Assert.assertEquals("www.google.com",data.url)

    }

    @Test
    fun `UserListResponse model test`(){
        var dataList=ArrayList<Data>()
        var support=Support("text","www.google.com")

        val data = UserListResponse(
            dataList,
            1,
            1,
            support,
            10,
            20
        )
        Assert.assertEquals(dataList,data.data)
        Assert.assertEquals(1,data.page)
        Assert.assertEquals(1,data.per_page)
        Assert.assertEquals(support,data.support)
        Assert.assertEquals(10,data.total)
        Assert.assertEquals(20,data.total_pages)

    }

    @Test
    fun `UserRes model test`(){

        val dataObj = Data(
            1,
            "Satish",
            2023,
            "test",
            "test"
        )
        var supportObj=Support("text","www.google.com")
        val data = UserRes(
            dataObj,
            supportObj
        )
        Assert.assertEquals(dataObj,data.data)
        Assert.assertEquals(supportObj,data.support)

    }

    @Test
    fun `UserResponse model test`() {
        val data = UserResponse(
            200,
            "Success"
        )
        Assert.assertEquals(200, data.httpCode)
        Assert.assertEquals("Success", data.message)

    }


}