/*
*修改排污许可证的大气主要污染物种类和废水主要污染物种类的类型
*/
alter table pollutant_discharge_permit modify column air_main_waste varchar(200);
alter table pollutant_discharge_permit modify column water_main_waste varchar(200);