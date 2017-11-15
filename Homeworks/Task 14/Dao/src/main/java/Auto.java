import lombok.*;

@AllArgsConstructor
@Builder
@EqualsAndHashCode
@ToString
@NoArgsConstructor
@Setter
@Getter

public class Auto {
    private Long ID;
    private String name;
    private String model;
    private String color;
}
