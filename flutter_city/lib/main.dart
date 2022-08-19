import 'package:flutter/material.dart';
import 'package:flutter_city/features/city/presentation/state_management/bindings/city_list_page_binding.dart';
import 'package:flutter_city/features/city/presentation/widget/city_list_page.dart';
import 'package:flutter_city/features/city/presentation/widget/data_api_page.dart';
import 'package:get/get.dart';

// flutter run -d chrome --web-hostname localhost --web-port 5000 --no-sound-null-safety

void main() {
  runApp(const MyApp());
}

class MyApp extends StatelessWidget {
  const MyApp({Key? key}) : super(key: key);

  // This widget is the root of your application.
  @override
  Widget build(BuildContext context) {
    return GetMaterialApp(
      debugShowCheckedModeBanner: false,
      title: 'City app',
      initialRoute: "/dataApi",
      getPages: [
        GetPage(
            name: "/cityLiest",
            page: () => CityListPage(),
            binding: CityListPageBinding()),

        GetPage(
          name: "/dataApi",
          page: () => DataApiPage(),
        ),
        // GetPage(
        //     name: "/PlainSignIn",
        //     page: () => MainPresentationHelper.getPlainSignIn()),
        // GetPage(
        //     name: "/home", page: () => MainPresentationHelper.getHomeView()),
        // GetPage(
        //     name: "/login",
        //     page: () => MainPresentationHelper.getLogin(),
        //     binding: LoginBinding()),
        // GetPage(
        //   name: "/welcome",
        //   page: () => MainPresentationHelper.getWelcome(),
        //   binding: WelcomeBinding(),
        // ),
      ],
    );
  }
}
