/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.avbravo.facturafacil;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import java.io.*;

/**
 *
 * @author avbravo
 */
public class ConUniRest {
     public static void main(String []args) throws Exception{
    Unirest.setTimeouts(0, 0);
    HttpResponse<JsonNode> response = Unirest.post("https://backend-qa-api.facturafacil.com.pa/api/pac/reception_fe/detailed/")
      .header("X-FF-Company", "8a6086a0-bc41-42e8-9c4f-9e7803feee2f")
      .header("X-FF-API-Key", "5K4FFtmv6ly8wiaxLVx2DsE1Fug1cc9C4g7WqumIa5elz9STj2edISTViBEzTrhFUuy0HsZ91p9TD_dtYLQI9zoElehyo3mwaxdye-tSAAiNvZcavvi-yO_YS2mMJ-ql")
      .header("X-FF-Branch", "1c4b8b34-61f7-471a-8dfe-a6a926237742")
      .header("Content-Type", "application/json")
      .header("Accept", "application/json")
      .body("{\n  \"header\": {\n    \"id\": 1,\n    \"environment\": \"2\"\n  },\n  \"document\": {\n    \"fd_number\": \"13\",\n    \"receptor\": {\n      \"type\": \"02\",\n      \"name\": \"Nombre Cliente\",\n      \"ruc_type\": \"1\",\n      \"address\": \"Dirección Cliente\",\n      \"email\": \"cliente@correo.com\",\n      \"ruc\": \"123123123\"\n    },\n    \"items\": [\n      {\n        \"line\": 1,\n        \"price\": 0.50,\n        \"mu\": \"und\",\n        \"quantity\": 1,\n        \"description\": \"Producto de prueba\",\n        \"taxes\": [\n          {\n            \"type\": \"01\",\n            \"amount\":0.035,\n            \"code\": \"01\"\n          }\n        ],\n        \"discount\": 0.0,\n        \"internal_code\": \"123123\"\n      }\n    ],\n    \"payments\": [\n      {\n        \"type\": \"99\",\n        \"amount\": \"0.54\",\n        \"description\": \"Medio de pago de prueba\"\n      }\n    ],\n    \"type\": \"01\",\n    \"info\": \"<string>\"\n  }\n}")
      .asJson();
    
    System.out.println(response.getBody());
  }
}
