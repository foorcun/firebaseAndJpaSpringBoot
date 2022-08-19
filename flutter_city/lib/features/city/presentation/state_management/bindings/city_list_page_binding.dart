import 'package:flutter_city/features/city/presentation/state_management/controller/city_controller.dart';
import 'package:get/get.dart';

class CityListPageBinding extends Bindings {
  @override
  void dependencies() {
    // TODO: implement dependencies
    Get.put<CityController>(CityController());
  }
}
