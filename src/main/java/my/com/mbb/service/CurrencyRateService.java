package my.com.mbb.service;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import my.com.mbb.model.dto.CurrencyCheckDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Service
@Slf4j
public class CurrencyRateService {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${third-party.currency.api.url}")
    private String currencyApi;

    @SneakyThrows
    public String getRates(CurrencyCheckDto currencyCheckDto) {
        String currencyUrl = decorateApiPath(currencyCheckDto);
        ResponseEntity<String> response = restTemplate.getForEntity(currencyUrl, String.class);
        return response.getBody();
    }

    private String decorateApiPath(CurrencyCheckDto currencyCheckDto) {
        String currencies = currencyCheckDto.getCurrencies();
        String base = currencyCheckDto.getBase();

        UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromHttpUrl(currencyApi);

        if (currencies != null && !currencies.isEmpty()) {
            uriBuilder.queryParam("currencies", currencies);
        }

        if (base != null && !base.isEmpty()) {
            uriBuilder.queryParam("base", base);
        }
        return uriBuilder.toUriString();
    }
}
