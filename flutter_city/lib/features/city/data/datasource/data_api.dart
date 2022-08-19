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

  static Future<http.Response> getResponse2() async {
    // Uri uri = Uri.parse("https://jsonplaceholder.typicode.com/users");
    // Uri uri = Uri.parse("http://www.mocky.io/v2/5dca69523300004e003decc5");
    Uri uri = Uri.parse("http://localhost:8080/get?documentId=user_2");

    http.Response response = await http.get(uri);
    print("gelenler : ");
    print(response.body);
    return response;
  }

  static Future<void> createUser() async {
    Uri uri = Uri.parse("http://localhost:8080/create");

    Map<String, dynamic> postData = {
      "documentId": "user_2",
      // "name": "Programming knowledge",
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

  static Future<void> patchUser2() async {
    // Uri uri = Uri.parse("http://localhost:8080/update");
  }

  static Future<void> putUser2() async {
    Uri uri = Uri.parse("http://localhost:8080/update");

    Map<String, dynamic> postData = {
      "documentId": "user_2", // bir bilgiyi eksik veririsek put kodu calismaz
      "name": "Programming knowledge",
      "profession": "youtuber + yeni data"
    };
    final body = jsonEncode(postData);

    var response = await http.put(
      uri,
      body: body,
      headers: {
        "Content-Type": "application/json",
      },
    );

    print("putUser2 response");
    print(response.body);
  }

  static Future<void> deleteUser2() async {
    Uri uri = Uri.parse("http://localhost:8080/delete?documentId=user_2");

    // Map<String, dynamic> postData = {
    //   "documentId": "user_2",
    // };
    // final body = jsonEncode(postData);

    var response = await http.put(
      uri,
      // body: body,
      headers: {
        "Content-Type": "application/json",
      },
    );

    print("putUser2 response");
    print(response.body);
  }
}
