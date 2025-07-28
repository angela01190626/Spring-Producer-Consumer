package dto;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;

@Api(value = "Message model info")
public class MessageDto {

    @ApiModelProperty(value = "Message id")
    private long id;

    @ApiModelProperty(value = "Message key")
    private String key;

    @ApiModelProperty(value = "Message value")
    private String value;

    public MessageDto() {
    }

    public MessageDto(String key, String value) {
       this.key = key;
       this.value = value;
    }

    public MessageDto(long id, String key, String value) {
        this(key, value);
        this.id = id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public long getId() {
        return id;
    }

    public String getKey() {
        return key;
    }

    public String getValue() {
        return value;
    }
}
