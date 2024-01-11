/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.avbravo.facturafacil;

import java.io.*;
import okhttp3.*;



/**
 *
 * @author avbravo
 */
public class Facturafacil {

   public static void main(String []args) throws IOException{
    OkHttpClient client = new OkHttpClient().newBuilder()
      .build();
    MediaType mediaType = MediaType.parse("application/json");
    RequestBody body = RequestBody.create(mediaType, "{\n  \"header\": {\n    \"id\": 1,\n    \"environment\": \"2\"\n  },\n  \"document\": {\n    \"fd_number\": \"12\",\n    \"receptor\": {\n      \"type\": \"02\",\n      \"name\": \"Nombre Cliente\",\n      \"ruc_type\": \"1\",\n      \"address\": \"Dirección Cliente\",\n      \"email\": \"cliente@correo.com\",\n      \"ruc\": \"123123123\"\n    },\n    \"items\": [\n      {\n        \"line\": 1,\n        \"price\": 0.50,\n        \"mu\": \"und\",\n        \"quantity\": 1,\n        \"description\": \"Producto de prueba\",\n        \"taxes\": [\n          {\n            \"type\": \"01\",\n            \"amount\":0.035,\n            \"code\": \"01\"\n          }\n        ],\n        \"discount\": 0.0,\n        \"internal_code\": \"123123\"\n      }\n    ],\n    \"payments\": [\n      {\n        \"type\": \"99\",\n        \"amount\": \"0.54\",\n        \"description\": \"Medio de pago de prueba\"\n      }\n    ],\n    \"type\": \"01\",\n    \"info\": \"<string>\"\n  }\n}");
    Request request = new Request.Builder()
      .url("https://backend-qa-api.facturafacil.com.pa/api/pac/reception_fe/detailed/")
      .method("POST", body)
      .addHeader("X-FF-Company", "8a6086a0-bc41-42e8-9c4f-9e7803feee2f")
      .addHeader("X-FF-API-Key", "5K4FFtmv6ly8wiaxLVx2DsE1Fug1cc9C4g7WqumIa5elz9STj2edISTViBEzTrhFUuy0HsZ91p9TD_dtYLQI9zoElehyo3mwaxdye-tSAAiNvZcavvi-yO_YS2mMJ-ql")
      .addHeader("X-FF-Branch", "1c4b8b34-61f7-471a-8dfe-a6a926237742")
      .addHeader("Content-Type", "application/json")
      .addHeader("Accept", "application/json")
      .build();
    Response response = client.newCall(request).execute();
    System.out.println(response.body().string());
  }

}
