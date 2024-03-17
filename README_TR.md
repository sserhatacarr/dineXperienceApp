# Dine Experience Uygulaması

[İngilizce README'ye git](README.md)

## Proje Mimarisi ve Sistem Tasarımı

[![Dine Experience Uygulaması Mimarisi](./img/n11_talenthub_final_project_design.png)](./img/n11_talenthub_final_project_design.png)

Dine Experience Application, N11 TalentHub Backend Bootcamp için geliştirilen kapsamlı bir projedir. Bu uygulama, mikroservisler mimarisi kullanılarak oluşturulmuştur ve beş ana modülden oluşur: discovery-server, api-gateway, user-service, restaurant-service ve logging-service. Discovery-server, mikroservisler arasında etkin iletişimi sağlayan bir servis kaydı görevi görür. Api-gateway, tüm istemci isteklerinin tek giriş noktası olarak hizmet verir ve bunları uygun servise yönlendirir. User-service, kullanıcıları ve restoranlar için yorumlarını yönetir, kullanıcı kaydı, yorum gönderme ve kullanıcı konumu ve restoran derecelendirmelerine dayalı kişiselleştirilmiş restoran önerileri gibi işlevler sunar. Restaurant-service, restoran kaydı ve listeleme dahil olmak üzere restoranlarla ilgili tüm işlemleri yönetir, tüm restoran verileri Apache Solr'da saklanır ve sorgulanır. Logging-service Bu, bir Spring Boot uygulaması için bir loglama servisidir. Mesaj tüketimi için Apache Kafka'yı ve veri depolama için MongoDB'yi kullanır. Servis, Kafka'dan hata loglarını tüketmek, bunları MongoDB'de saklamak ve logları almak için tasarlanmıştır. Bu depoda bulunan her servis kendi README.md dosyasına sahiptir ve proje hakkında ayrıntılı bilgi sağlar. 

## Servisler

- [Discovery Server](./discovery-server/README.md): Servis keşfi ve kaydı sağlayan bir Spring Boot uygulamasıdır. Netflix Eureka'yı servisleri kaydetmek ve keşfetmek için kullanır. Discovery Servisi, tüm istemciler için tek giriş noktasıdır. İstekleri uygun servise yönlendirir.

- [API Gateway](./api-gateway/README.md): Kullanıcıları ve restoranları yönetmek için bir RESTful API sağlayan bir Spring Boot uygulamasıdır. Kullanıcıları ve restoranları oluşturma, alama, güncelleme ve silme işlemlerini içerir. API Gateway, tüm istemciler için tek giriş noktasıdır. İstekleri uygun servise yönlendirir. Ayrıca kullanıcıları doğrulama ve yetkilendirme yolu da sağlar.

- [User Service](./user-service/README.md): Kullanıcıları ve kullanıcı yorumlarını yönetmek için bir RESTful API sağlayan bir Spring Boot uygulamasıdır. Kullanıcıları ve kullanıcı yorumlarını oluşturma, alama, güncelleme ve silme işlemlerini içerir. Her kullanıcının ilişkilendirilmiş enlem ve boylam değerleri vardır. Kullanıcı yorumlarının 1 ile 5 arasında bir puanı vardır.

- [Restaurant Service](./restaurant-service/README.md): Restoranları yönetmek için bir RESTful API sağlayan bir Spring Boot uygulamasıdır. Restoranları oluşturma, alama, güncelleme ve silme işlemlerini içerir. Her restoranın ilişkilendirilmiş enlem ve boylam değerleri vardır. Restoran verileri Apache Solr'da saklanır ve sorgular da Solr'a yapılır. Servis ayrıca, kullanıcının konumuna ve restoranın puanına dayalı restoran önerileri sağlayan bir API de sunar.

- [Logging Service](./logging-service/README.md): Bu, Spring Boot uygulaması için bir loglama servisidir. Mesaj tüketimi için Apache Kafka'yı ve veri depolama için MongoDB'yi kullanır. Servis, Kafka'dan hata loglarını tüketmek, bunları MongoDB'de saklamak ve logları almak için tasarlanmıştır.