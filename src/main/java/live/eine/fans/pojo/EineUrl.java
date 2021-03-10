package live.eine.fans.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EineUrl {
    private Integer id;
    private String webUri;
    private String webName;
    private String linkUrl;
    private String shortUri;

}
