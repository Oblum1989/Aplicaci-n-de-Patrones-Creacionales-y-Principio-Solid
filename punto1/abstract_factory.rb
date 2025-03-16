## Implementación del Patrón en Ruby
## El código tiene cuatro partes clave:

# 1. Interfaces Base para los Componentes (Abstract Product)
# Se definen interfaces para los componentes gráficos que cambian según el tema:
# Productos Abstractos
class Button
  def render
    raise NotImplementedError, 'Debes implementar el método render'
  end
end

class Menu
  def show
    raise NotImplementedError, 'Debes implementar el método show'
  end
end

class Background
  def display
    raise NotImplementedError, 'Debes implementar el método display'
  end
end

# Cada una de estas clases tiene métodos como `render`, `show` o `display`,
# que serán implementados por las clases concretas.

# 2. Implementaciones Concretas de los Componentes (Concrete Product)
# Cada tema tiene sus propias versiones de botones, menús y fondos:

# **DarkButton**, **LightButton**, **HighContrastButton**
# **DarkMenu**, **LightMenu**, **HighContrastMenu**
# **DarkBackground**, **LightBackground**, **HighContrastBackground**

# Cada clase implementa el comportamiento específico de su versión del componente.

# Productos Concretos
class DarkButton < Button
  def render
    puts 'Renderizando botón oscuro'
  end
end

class LightButton < Button
  def render
    puts 'Renderizando botón claro'
  end
end

class HighContrastButton < Button
  def render
    puts 'Renderizando botón de alto contraste'
  end
end

class DarkMenu < Menu
  def show
    puts 'Mostrando menú oscuro'
  end
end

class LightMenu < Menu
  def show
    puts 'Mostrando menú claro'
  end
end

class HighContrastMenu < Menu
  def show
    puts 'Mostrando menú de alto contraste'
  end
end

class DarkBackground < Background
  def display
    puts 'Mostrando fondo oscuro'
  end
end

class LightBackground < Background
  def display
    puts 'Mostrando fondo claro'
  end
end

class HighContrastBackground < Background
  def display
    puts 'Mostrando fondo de alto contraste'
  end
end

### 3. La Fábrica Abstracta (Abstract Factory)

# Se define `ThemeFactory`, que establece los métodos que las fábricas concretas deben implementar:

# `create_button`
# `create_menu`
# `create_background`

# Fábrica Abstracta
class ThemeFactory
  def create_button
    raise NotImplementedError, 'Debes implementar create_button'
  end

  def create_menu
    raise NotImplementedError, 'Debes implementar create_menu'
  end

  def create_background
    raise NotImplementedError, 'Debes implementar create_background'
  end
end

# 4. Implementaciones Concretas de la Fábrica (Concrete Factory)
# Se crean tres fábricas que implementan `ThemeFactory`, cada una generando los componentes de su respectivo tema:

# **DarkThemeFactory**
# **LightThemeFactory**
# **HighContrastFactory**

# Cada fábrica instancia los objetos correctos de `Button`, `Menu` y `Background` para su tema.
# Fábricas Concretas
class DarkThemeFactory < ThemeFactory
  def create_button
    DarkButton.new
  end

  def create_menu
    DarkMenu.new
  end

  def create_background
    DarkBackground.new
  end
end

class LightThemeFactory < ThemeFactory
  def create_button
    LightButton.new
  end

  def create_menu
    LightMenu.new
  end

  def create_background
    LightBackground.new
  end
end

class HighContrastFactory < ThemeFactory
  def create_button
    HighContrastButton.new
  end

  def create_menu
    HighContrastMenu.new
  end

  def create_background
    HighContrastBackground.new
  end
end

# 5. Aplicación que Usa la Fábrica

# Finalmente, la clase `Application` recibe una fábrica como parámetro y
# genera los componentes de la UI con el tema seleccionado.
# Cliente
class Application
  def initialize(factory)
    @button = factory.create_button
    @menu = factory.create_menu
    @background = factory.create_background
  end

  def render_ui
    @button.render
    @menu.show
    @background.display
  end
end

# Ejecución de ejemplo
# Ejecución de ejemplo
puts 'Usando el tema oscuro:'
dark_app = Application.new(DarkThemeFactory.new)
dark_app.render_ui

puts '\nUsando el tema claro:'
light_app = Application.new(LightThemeFactory.new)
light_app.render_ui

puts '\nUsando el tema de alto contraste:'
high_contrast_app = Application.new(HighContrastFactory.new)
high_contrast_app.render_ui
