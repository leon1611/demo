package com.example.demo.controller

import com.example.demo.model.Model
import com.example.demo.response.ErrorResponse
import com.example.demo.response.FailedResponse
import com.example.demo.response.SuccessResponse
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/home")
class HomeController {

    @GetMapping
    fun home(@RequestBody model: Model): SuccessResponse{
        return SuccessResponse().apply {
            status ="success"
            data = model
        }
    }

    @GetMapping("/failed")
    fun getModel(@RequestBody model: Model): FailedResponse{
        return FailedResponse().apply {
            status ="failed"
            data = "El campo nombre esta vacio"
        }
    }

    @GetMapping("/error")
    fun errorModel(): ErrorResponse {
        return ErrorResponse().apply {
            status = "error"
            data = "Ocurrió un error en la solicitud"
        }
    }

}