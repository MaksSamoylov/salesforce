package utils;

import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import lombok.SneakyThrows;
import lombok.experimental.UtilityClass;
import org.apache.hc.core5.http.NameValuePair;
import org.apache.hc.core5.http.message.BasicNameValuePair;
import org.apache.hc.core5.net.URIBuilder;

@UtilityClass
public class UrlUtils {

  /**
   * Add query parameters to url path.
   *
   * <p>Path: 'https://example.com' -> 'https://example.com?id=555'<p/>.
   *
   * @param path        url path prefix to modified
   * @param queryParams parameters to add to url
   * @return            modified url path with query parameters
   */
  @SneakyThrows(URISyntaxException.class)
  public String addQueryParameters(String path, Map<String, String> queryParams) {
    List<NameValuePair> parameters = queryParams.entrySet().stream()
        .map(param -> new BasicNameValuePair(param.getKey(), param.getValue()))
        .collect(Collectors.toList());
    return new URIBuilder(path).addParameters(parameters).build().toString();
  }

  /**
   * Convert url {@link java.lang.String} object to {@link java.net.URL} object.
   *
   * @param url url path to convert
   * @return    {@link java.net.URL} class object
   */
  @SneakyThrows(MalformedURLException.class)
  public URL convertToUrl(String url) {
    return new URL(url);
  }
}
