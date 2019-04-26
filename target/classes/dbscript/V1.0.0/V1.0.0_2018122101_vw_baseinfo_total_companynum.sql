CREATE OR REPLACE VIEW vw_baseinfo_total_companynum AS
SELECT count(1) AS `count`,'全区企业统计' AS `name`,'1' AS `type` FROM cominfo_baseinfo
UNION ALL
SELECT count(1) AS `count`,'重点污染源' AS `name`,'2' AS `type` FROM cominfo_environmental_manage WHERE key_source=1
UNION ALL
SELECT count(1) AS `count`,'固废产废源' AS `name`,'3' AS `type` FROM cominfo_environmental_manage WHERE waste_generation=1
UNION ALL
SELECT count(1) AS `count`,'在线监控企业' AS `name`,'4' AS `type` FROM cominfo_environmental_manage WHERE online_monitoring=1
UNION ALL
SELECT count(1) AS `count`,'放射源' AS `name`,'5' AS `type` FROM (SELECT a.pid FROM cominfo_baseinfo a,radioactive_isotope_info b WHERE a.pid=b.cid GROUP BY a.pid) c
UNION ALL
SELECT count(1) AS `count`,'风险源' AS `name`,'6' AS `type` FROM cominfo_environmental_manage WHERE risk_source=1
UNION ALL
SELECT count(1) AS `count`,'污水处理厂' AS `name`,'7' AS `type` FROM cominfo_environmental_manage WHERE sewage_plant=1
UNION ALL
SELECT count(1) AS `count`,'重点排污源' AS `name`,'8' AS `type` FROM (SELECT * FROM cominfo_environmental_manage WHERE key_source=1) a WHERE a.waste_water=1 OR a.emission_enterprises=1 OR a.voc_enterprises=1
UNION ALL
SELECT count(1) AS `count`,'产VOCs源' AS `name`,'9' AS `type` FROM cominfo_environmental_manage WHERE voc_enterprises=1
UNION ALL
SELECT count(1) AS `count`,'工业废水排放' AS `name`,'10' AS `type` FROM cominfo_environmental_manage WHERE waste_water=1 AND online_monitoring=1