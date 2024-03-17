# Discovery Servisi

[İngilizce README'ye git](README.md)

Discovery Servisi, mikroservis mimarimizin anahtar bir bileşenidir. Mikroservislerin kaydını sağlar ve hizmet keşfi sağlar, bu da hizmetlerin yük dengelemesi ve failover için önemlidir.


## Ana Özellikler

- Tüm mikroservisleri kaydeder.
- Yük dengelemesi ve failover için hizmet keşfini sağlar.
- Spring Boot ve Eureka ile entegre olur.

## Yapılandırma

Discovery Servisi'nin yapılandırması `application.yml` dosyasında bulunur. Bu dosya, servisin hangi portta çalışacağını ve Eureka istemci yapılandırmasını belirtir.



## Docker

Bu servis, Docker'da çalışacak şekilde paketlenmiştir. Dockerfile, Docker imajının nasıl oluşturulacağını belirtir.

## Çalıştırma

Docker imajını oluşturmak ve çalıştırmak için aşağıdaki komutları kullanabilirsiniz:

```bash
docker build -t discovery-service .
docker run -p 8761:8761 discovery-service
```

Bu komutlar önce Docker imajını oluşturur ve ardından discovery-service'i 8761 portunda çalıştırır.

## Bağımlılıklar

- **Spring Boot:** Discovery Servisi, Spring Boot kullanılarak oluşturulmuştur.
- **Eureka Server:** Discovery Servisi, hizmet kaydı ve keşfi için Eureka Server'ı kullanır.

Lütfen tüm mikroservislerin hizmet keşfinin doğru bir şekilde çalışması için Discovery Servisi'ne kaydolması gerektiğini unutmayın.

## İletişim

### Serhat Acar

<a href="https://github.com/sserhatacarr" target="_blank">
<img  src=https://img.shields.io/badge/github-%2324292e.svg?&style=for-the-badge&logo=github&logoColor=white alt=github style="margin-bottom: 20px;" />
</a>
<a href = "mailto:sserhatacarr@gmail.com?subject = Geri Bildirim&body = Mesaj">
<img src=https://img.shields.io/badge/send-email-email?&style=for-the-badge&logo=microsoftoutlook&color=CD5C5C alt=gmail style="margin-bottom: 20px; margin-left:20px" />
</a>
<a href="https://linkedin.com/in/sserhatacarr" target="_blank">
<img src=https://img.shields.io/badge/linkedin-%231E77B5.svg?&style=for-the-badge&logo=linkedin&logoColor=white alt=linkedin style="margin-bottom: 20px; margin-left:20px" />
</a>  

## Talenthub Bootcamp - N11 & Patika

<div align="center">
  <a href="https://www.n11.com/">
    <img src="../img/n11-logo.png" alt="Logo" width="220" height="140">
  </a>

<h3 align="center">Şirket: N11.com</h3>
</div>

<div align="center">
  <a href="https://www.patika.dev/">
    <img src="../img/patika-logo.png" alt="Logo" width="350" height="300">
  </a>
<h3 align="center">Organizatör: Patika.dev</h3>   
</div>
