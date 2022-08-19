import 'package:flutter_city/features/city/domain/entity/city.dart';
import 'package:http/http.dart' as http;

class CityService {
  static Future<List<City>> getCityler() async {
    Uri uri = Uri.parse("http://localhost:8080/get?documentId=user_1");
    // Uri uri = Uri.parse("http://www.mocky.io/v2/5dca69523300004e003decc5");

    http.Response response = await http.get(uri);
    // print("gelenler : " + response.body);
    // return response;

    // List listJson = JsonHelper.convertResponseToList(response.body);
    List<City> cityList = [];
    // for (var i = 0; i < listJson.length; i++) {
    //   cityList.add(DiziModel.fromJson(listJson[i]));
    // }

    return cityList;
  }
}
