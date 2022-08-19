import 'dart:convert';

import 'package:http/http.dart' as http;

class DataApi {
  static printTest() {
    print("deneme printi");
  }

  static Future<http.Response> getResponse() async {
    // Uri uri = Uri.parse("https://jsonplaceholder.typicode.com/users");
    // Uri uri = Uri.parse("http://www.mocky.io/v2/5dca69523300004e003decc5");
    Uri uri = Uri.parse("http://localhost:8080/get?documentId=user_1");

    http.Response response = await http.get(uri);
    print("gelenler : ");
    print(response.body);
    return response;
  }

  static Future<void> createUser() async {
    Uri uri = Uri.parse("http://localhost:8080/create");

    Map<String, dynamic> postData = {
      "documentId": "user_2",
      "name": "Programming knowledge",
      "profession": "youtuber"
    };
    final body = jsonEncode(postData);

    var response = await http.post(
      uri,
      body: body,
      headers: {
        "Content-Type": "application/json",
      },
    );

    print("createUser response");
    print(response.body);

//     {
//     "documentId":"user_2",
//     "name":"Programming knowledge",
//     "profession":"youtuber"

// }
  }
}
