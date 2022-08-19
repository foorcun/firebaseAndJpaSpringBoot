import 'package:flutter/material.dart';
import 'package:flutter/src/foundation/key.dart';
import 'package:flutter/src/widgets/framework.dart';
import 'package:flutter_city/features/city/data/datasource/data_api.dart';

import 'package:flutter/src/foundation/key.dart';
import 'package:flutter/src/widgets/framework.dart';

class DataApiPage extends StatelessWidget {
  const DataApiPage({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    DataApi.printTest();
    // DataApi.getResponse();
    return Scaffold(
      // appbar:App
      appBar: AppBar(title: Text("api test")),
      body: Column(
        children: [
          ElevatedButton(
            onPressed: () async {
              DataApi.getResponse();
            },
            child: Text("Read user_1"),
          ),
          ElevatedButton(
            onPressed: () async {
              DataApi.getResponse2();
            },
            child: Text("Read user_2"),
          ),
          ElevatedButton(
            onPressed: () async {
              DataApi.createUser();
            },
            child: Text("create user_2 - POST"),
          ),
          ElevatedButton(
            onPressed: () async {
              DataApi.putUser2();
            },
            child: Text("put"),
          ),
          ElevatedButton(
            onPressed: () async {
              DataApi.deleteUser2();
            },
            child: Text("delete"),
          ),
        ],
      ),
    );
  }
}
