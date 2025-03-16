## Se define `GraphicObject` como una clase base abstracta,
## donde `render` debe ser implementado por las subclases.
class GraphicObject
  def render
    raise NotImplementedError, 'Subclasses must implement the render method'
  end
end

## Se crean `Sprite2D`, `Model3D` y `ParticleEffect`,
## cada una implementa su propio `render`.
class Sprite2D < GraphicObject
  def render
    'Rendering a 2D Sprite'
  end
end

class Model3D < GraphicObject
  def render
    'Rendering a 3D Model'
  end
end

class ParticleEffect < GraphicObject
  def render
    'Rendering a Particle Effect'
  end
end

## `GraphicObjectFactory` actúa como una clase abstracta para definir `create_object`,
## que será implementado en `GameGraphicFactory`.
class GraphicObjectFactory
  def create_object(type)
    raise NotImplementedError, 'Subclasses must implement the create_object method'
  end
end

## `GameGraphicFactory` implementa `create_object`
## y devuelve la instancia adecuada según el tipo recibido.
class GameGraphicFactory < GraphicObjectFactory
  def create_object(type)
    case type
    when '2D'
      Sprite2D.new
    when '3D'
      Model3D.new
    when 'Particle'
      ParticleEffect.new
    else
      raise ArgumentError, 'Unknown graphic object type'
    end
  end
end

#### 5. En `main` probamos la fábrica creando objetos gráficos y llamando a `render()`.
def main
  factory = GameGraphicFactory.new

  ['2D', '3D', 'Particle'].each do |type|
    graphic_object = factory.create_object(type)
    puts graphic_object.render
  end
end

## Se llama a `main` para ejecutar el programa.
main
