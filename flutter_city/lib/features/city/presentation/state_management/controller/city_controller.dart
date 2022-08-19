import 'package:flutter_city/features/city/domain/entity/city.dart';
import 'package:flutter_city/features/city/presentation/state_management/service/city_service.dart';
import 'package:get/get.dart';

class CityController extends GetxController {
  final cityler = <City>[].obs;

  @override
  void onInit() {
    // TODO: implement onInit
    super.onInit();

    fetchCityler();
  }

  fetchCityler() async {
    var d = await CityService.getCityler();
  }
}
